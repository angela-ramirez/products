/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madein.ecommerce.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@XmlRootElement
public class Product  implements  Serializable {
    
    protected List<ProductAttribute> productAttributes;
    protected List<Image> images;
    
    
    public Product() {
        productAttributes =  new ArrayList<>();
        images = new ArrayList<>();
    }

    /**
     * @return the productAttributes
     */
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    /**
     * @param productAttributes the productAttributes to set
     */
    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }
}
