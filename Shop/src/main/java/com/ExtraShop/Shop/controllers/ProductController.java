package com.ExtraShop.Shop.controllers;

import com.ExtraShop.Shop.data.entities.Product;
import com.ExtraShop.Shop.data.repositories.ProductRepository;
//import com.ExtraShop.Shop.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    //GET
    //POST
    //PUT
    //DELETE
//    private static LinkedList<Product> List;
    private final ProductRepository productRepository;
    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
//        int[] arr = {1,2,3,4,5,6,7};
//        Arrays.stream(arr).();
        //Thread
//        List = new LinkedList<>();
//        List.add(new Product(1,"Product1", "https://picsum.photos/500", 10, 5));
//        List.add(new Product(2,"Product2", "https://picsum.photos/500", 11, 5));
//        List.add(new Product(3,"Product3", "https://picsum.photos/500", 20, 5));
//        List.add(new Product(4,"Product4", "https://picsum.photos/500", 13, 5));
//        List.add(new Product(5,"Product5", "https://picsum.photos/500", 40, 5));
    }

    @GetMapping("/get-all-product")
    public ResponseEntity GetAllProduct(){

        var products = this.productRepository.getAll();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity GetById(@PathVariable int id){

        var product = this.productRepository.findById(id);
        return ResponseEntity.ok(product);

//        int a = 3;
//        if(a % 2 == 0){
//            System.out.println("Yes");
//        }
//        else{
//            System.out.println("No");
//        }
//
//        System.out.println( a % 2 == 0 ? "Yes" : "No");



//        var product = List.stream().filter(p->p.getId() == id).findFirst();
//        return product == null
//                ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
//                : ResponseEntity.ok(product);



//        for (int i = 0; i < List.size(); i ++){
//            if(List.get(i).getId() == id )
//                return ResponseEntity.ok(List.get(i));
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/add")
    public ResponseEntity AddProduct(@RequestBody Product product){
        var productResult = this.productRepository.save(product);
        return ResponseEntity.ok(productResult);

//        var res = List.stream().map(p->p.getId()).max(java.lang.Integer::compare);
//        product.setId(res.get()+1);
//        List.add(product);
//        return product;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteProduct(@PathVariable int id){
        this.productRepository.deleteById(id);
//        for(int i = 0; i< List.size();i++){
//            if(List.get(i).getId()==id)
//                List.remove(i);
//            break;
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
//  @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> DeleteProduct(@PathVariable int id) {
//        boolean removed = List.removeIf(product -> product.getId() == id);
//        if (removed) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateProduct(@PathVariable int id, @RequestBody Product product){
        var productResult = this.productRepository.save(product);
//        for(int i = 0; i< List.size();i++){
//            var storageProduct = List.get(i);
//            if(storageProduct.getId() == id){
//                storageProduct.setName(product.getName());
//                storageProduct.setPrice(product.getPrice());
//                storageProduct.setQuantity(product.getQuantity());
//
//                return product;
//            }
//        }
        return ResponseEntity.ok(productResult);
    }
}
