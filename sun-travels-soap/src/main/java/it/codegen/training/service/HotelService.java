package it.codegen.training.service;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class HotelService {
    @WebMethod
    public String welcome(){
        return "Hi Welcome !";
    }
}
