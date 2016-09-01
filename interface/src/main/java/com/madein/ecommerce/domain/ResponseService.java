package com.madein.ecommerce.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
* Response of the Rest Service  <br>
* Creation Info:
* date 31/08/2016
* @author Andres Felipe Lopez Rodriguez
**/
@XmlRootElement
public class ResponseService implements Serializable{
    private String status;
    private Object output;
    private String detail;

    public ResponseService() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    
}