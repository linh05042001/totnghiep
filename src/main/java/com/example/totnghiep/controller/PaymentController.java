package com.example.totnghiep.controller;


import com.example.totnghiep.Config.VnpayConfig;
import com.example.totnghiep.Dto.*;
import com.example.totnghiep.model.Bill;
import com.example.totnghiep.model.Cart;
import com.example.totnghiep.model.Category;
import com.example.totnghiep.model.DetailsCart;
import com.example.totnghiep.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("api/v1/payment")
public class PaymentController {
    @Autowired
    private CartService cartService;
    @Autowired
    private DetailsCartService detailsCartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BillService billService;
    @Autowired
    private DetailsBillService detailsBillService;


    @ModelAttribute("paymentdto")
    public PaymentDto paymentDto(){
        return new PaymentDto();
    }
    @GetMapping("/getpayment/{id}")
    public String getEdit(@PathVariable("id") long id, Model model){
        cartService.addTotalCart(id);
        model.addAttribute("cart", cartService.getCartById(id));
        model.addAttribute("idname", id);
        List<DetailsCart> dt=detailsCartService.getbyCart(id);
        List<CartAllDto> call=new ArrayList<>();
        for (DetailsCart s:dt){
            Category category= categoryService.getCategorybyId(s.getCategoryid());
            CartAllDto ct = new CartAllDto(
                    s.getId(),
                    s.getCartid(),
                    category.getId(),
                    category.getName(),
                    category.getImage(),
                    s.getSize(),
                    s.getNumber(),
                    (s.getNumber()*Integer.parseInt(category.getPrice()))+"",
                    category.getPrice()

            );
            call.add(ct);
        }
        model.addAttribute("detailscartall",call);
        return "payment";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("paymentdto") PaymentDto paymentDto) throws UnsupportedEncodingException {
        Cart us=cartService.getCartById(paymentDto.getCartid());
        String a=java.time.LocalTime.now()+"";
        BillDto b1= new BillDto(0,java.time.LocalDate.now()+"",us.getCustomerid(),a,"vnpay",paymentDto.getName(),paymentDto.getAddress(),paymentDto.getTel(),paymentDto.getPaymenttotal()+"");
        billService.addBill(b1);
        Bill b3= billService.getBillByNote(us.getCustomerid(),a);
        List<DetailsCart> dt=detailsCartService.getbyCart(paymentDto.getCartid());
        for (DetailsCart s:dt){
            Category category= categoryService.getCategorybyId(s.getCategoryid());
            DetailsBillDto b2 = new DetailsBillDto(0,s.getCategoryid(),b3.getId(),Integer.parseInt(category.getPrice()),s.getNumber());
            detailsBillService.addDb(b2);
        }
        double doubleNumber = Double.parseDouble(paymentDto.getPaymenttotal());
        long kt=1;
        detailsCartService.deleteall(us.getId());
        cartService.addTotalCart(us.getId());
        DecimalFormat decimalFormat = new DecimalFormat("#"); // "#.#" để giữ lại một chữ số thập phân nếu có
        String formattedNumber = decimalFormat.format(doubleNumber);
        int intNumber = Integer.parseInt(formattedNumber);
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";

        long amount = intNumber*100;
        String bankCode = "NCB";

        String vnp_TxnRef = VnpayConfig.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = VnpayConfig.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", VnpayConfig.vnp_ReturnUrl+"/"+us.getCustomerid());
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VnpayConfig.hmacSHA512(VnpayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnpayConfig.vnp_PayUrl + "?" + queryUrl;

        return "redirect:"+paymentUrl;
    }

    @GetMapping("/getthanhcong/{id}")
    public String getThanhcong(@PathVariable(value = "id") Long id,@RequestParam(value = "vnp_Amount") String price,@RequestParam(value = "vnp_ResponseCode") String success,@RequestParam(value = "vnp_OrderInfo") String orderinfo,Model model){
        int a= Integer.parseInt(price);

        model.addAttribute("price", a/100);
        if(success.equals("00")){
            model.addAttribute("tb","Thanh toan thanh cong");
        }else {
            model.addAttribute("tb","Thanh toan that bai");
        }
        model.addAttribute("orderinfo",orderinfo);
        model.addAttribute("idname",id);
        return "paysucess";
    }
}
