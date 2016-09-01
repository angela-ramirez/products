/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madein.ecommerce.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres Lopez
 */
@XmlRootElement
public class Section  implements  Serializable {
    private String name;
    private List<Product> productList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "co.com.expertla.neroo.jpa.model.JpaExamFormat[ examFormatId=" + name + " ]";
    }
    
}
