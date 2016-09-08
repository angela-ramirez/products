/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madein.services;

import com.google.common.io.Files;
import com.madein.ecommerce.domain.Image;
import com.madein.ecommerce.domain.Product;
import com.madein.ecommerce.domain.ProductAttribute;
import com.madein.ecommerce.domain.ResponseService;
import com.madein.ecommerce.domain.Section;
import com.madein.ecommerce.enums.StatusResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author oiprado
 */
@Path("Products")
@RequestScoped
public class ProductResource {

    public ProductResource() {
    }

    @GET
    @Path("sections/{language}/{country}/{first}/{max}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSections(@PathParam("language") String language,
            @PathParam("country") String country,
            @PathParam("first") Integer first,
            @PathParam("max") Integer max) throws IOException {
        ResponseService responseService = new ResponseService();
        List<Section> sections = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        List<Product> productAll = addProduct();

        for (int i = first; i < max; i++) {
            products.add(productAll.get(i));
        }

        Section section = new Section();
        section.setId(1);
        section.setProductList(products);
        section.setName("section1");
        section.setCountProducts(6);
        sections.add(section);

        section = new Section();
        section.setId(2);
        section.setProductList(products);
        section.setName("section2");
        section.setCountProducts(3);
        sections.add(section);
        responseService.setOutput(sections);
        responseService.setStatus(StatusResponse.SUCCESS.getName());
        return Response.status(Response.Status.OK).entity(sections).build();
    }

    @GET
    @Path("sections/{language}/{country}/{first}/{max}/{sectionId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSectionById(@PathParam("language") String language,
            @PathParam("country") String country,
            @PathParam("first") Integer first,
            @PathParam("max") Integer max,
            @PathParam("sectionId") Integer sectionId) throws IOException {
        ResponseService responseService = new ResponseService();
        List<Section> sections = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        List<Product> productAll = addProduct();

        if (first > 0 && max > 0) {
            for (int i = first; i < max; i++) {
                products.add(productAll.get(i));
            }
        } else {
            products = addProduct();
        }

        Section section = new Section();
        section.setId(1);
        section.setProductList(products);
        section.setName("section1");
        section.setCountProducts(6);

        if (sectionId == section.getId()) {
            responseService.setOutput(section);
            responseService.setStatus(StatusResponse.SUCCESS.getName());
            return Response.status(Response.Status.OK).entity(section).build();
        }

        section = new Section();
        section.setId(2);
        section.setProductList(products);
        section.setName("section2");
        section.setCountProducts(3);

        if (sectionId == section.getId()) {
            responseService.setOutput(section);
            responseService.setStatus(StatusResponse.SUCCESS.getName());
            return Response.status(Response.Status.OK).entity(section).build();
        }

        responseService.setOutput(null);
        responseService.setStatus(StatusResponse.SUCCESS.getName());
        return Response.status(Response.Status.OK).entity(sections).build();
    }

    private List<Product> addProduct() throws IOException {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product();
        p1.setProductId(1);
        p1.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p1.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px1 = new File("C:\\Users\\USER\\Downloads\\android calendar.PNG");

        p1.getImages().add(new Image(Files.toByteArray(px1), "photo1", "jpg", "6,9 kB"));

        Product p2 = new Product();
        p2.setProductId(2);
        p2.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p2.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px2 = new File("C:\\Users\\USER\\Downloads\\informatica_calendar-android-vista-mes.png");

        p2.getImages().add(new Image(Files.toByteArray(px2), "photo2", "jpg", "6,9 kB"));

        Product p3 = new Product();
        p3.setProductId(3);
        p3.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p3.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px3 = new File("C:\\Users\\USER\\Downloads\\IMG_20150425_162256845.jpg");

        p3.getImages().add(new Image(Files.toByteArray(px3), "photo3", "jpg", "6,9 kB"));

        Product p4 = new Product();
        p4.setProductId(4);
        p4.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p4.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px4 = new File("C:\\Users\\USER\\Downloads\\IMG_20150413_225442574.jpg");

        p4.getImages().add(new Image(Files.toByteArray(px4), "photo4", "jpg", "6,9 kB"));

        Product p5 = new Product();
        p5.setProductId(5);
        p5.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p5.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px5 = new File("C:\\Users\\USER\\Downloads\\IMG_20150413_225442574.jpg");

        p5.getImages().add(new Image(Files.toByteArray(px5), "photo5", "jpg", "6,9 kB"));

        Product p6 = new Product();
        p6.setProductId(1);
        p6.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p6.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p6.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p6.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p6.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p6.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p6.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px6 = new File("C:\\Users\\USER\\Downloads\\IMG_20150413_225442574.jpg");

        p6.getImages().add(new Image(Files.toByteArray(px6), "photo6", "jpg", "6,9 kB"));

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

        return products;
    }
    
    @GET
    @Path("product/get/by/id/{id}/{language}/{country}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProductDetail(@PathParam("language") String language, @PathParam("id") String productId,@PathParam("country") String country) throws IOException {
        ResponseService responseService = new ResponseService();
        List<Product> products = new ArrayList<>();

        Product p1 = new Product();

        p1.setProductId(1);
        p1.getProductAttributes().add(new ProductAttribute("Nombre", "Producto 1", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p1.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p1.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo1.jpg");
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo2.jpg");
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");

        p1.getImages().add(new Image(Files.toByteArray(file1), "px1", "jpg", "6,9 kB"));
        p1.getImages().add(new Image(Files.toByteArray(file2), "px1", "jpg", "6,9 kB"));
        p1.getImages().add(new Image(Files.toByteArray(file3), "px1", "jpg", "6,9 kB"));

        Product p2 = new Product();

        p2.setProductId(2);
        p2.getProductAttributes().add(new ProductAttribute("Nombre", "Producto xxx", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p2.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p2.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");
        file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");
        file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo4.jpg");
        file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo5.jpg");
        p2.getImages().add(new Image(Files.toByteArray(px2), "photo2", "jpg", "6,9 kB"));
        p2.getImages().add(new Image(Files.toByteArray(file1), "photo2", "jpg", "6,9 kB"));
        p2.getImages().add(new Image(Files.toByteArray(file2), "photo2", "jpg", "6,9 kB"));
        p2.getImages().add(new Image(Files.toByteArray(file3), "photo2", "jpg", "6,9 kB"));

        Product p3 = new Product();

        p3.setProductId(3);
        p3.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p3.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p3.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");

        p3.getImages().add(new Image(Files.toByteArray(px3), "photo3", "jpg", "6,9 kB"));

        Product p4 = new Product();

        p4.setProductId(4);
        p4.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p4.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p4.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");

        p4.getImages().add(new Image(Files.toByteArray(px4), "photo4", "jpg", "6,9 kB"));

        Product p5 = new Product();

        p5.setProductId(5);
        p5.getProductAttributes().add(new ProductAttribute("Nombre", "xxxxxxxxxxxx xxx", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Suela", "Goma", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Tipo", "Casual", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Referencia", "NA365X", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Nùmero de referencia", "11978456213", "java.lang.Integer"));
        p5.getProductAttributes().add(new ProductAttribute("Id", "82707ad7-6897-11e6-af9c-002219e6669f", "java.lang.String"));
        p5.getProductAttributes().add(new ProductAttribute("Precio", "90000", "java.lang.Integer"));

        File px5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\Productos\\interface\\src\\main\\webapp\\resources\\images\\photo3.jpg");

        p5.getImages().add(new Image(Files.toByteArray(px5), "photo5", "jpg", "6,9 kB"));

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        for (Product product : products) {
            if(product.getProductId().equals(new Integer(productId))) {
                p1 = new Product();
                p1 = product;
                break;
            }
        }
        responseService.setOutput(p1);
        responseService.setStatus(StatusResponse.SUCCESS.getName());
        return Response.status(Response.Status.OK).entity(p1).build();
    }

}
