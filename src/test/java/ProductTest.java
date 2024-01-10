/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import com.mkl.mybatisrep.domain.Product;
import com.mkl.mybatisrep.services.ProductService;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {

    private static ProductService productService;

    @BeforeClass
    public static void setup() {
        productService = new ProductService();
    }

    @AfterClass
    public static void teardown() {
        productService = null;
    }

    @Test
    public void testGetProductById() {
        Product product = productService.findById(2);
        Assert.assertNotNull(product);
        System.out.println(product);

    }

    @Test
    public void testInsertBlog() {
        Product product = new Product();
        product.setCbarang("021");
        product.setVnama_barang("Nama Test 01");

        int i = productService.createProduct(product);
        Assert.assertTrue(i > 0);
        System.out.println("created id : " +product.getId());
        Product createdProduct = productService.findById(product.getId());
        Assert.assertNotNull(createdProduct);
        Assert.assertEquals(product.getVnama_barang(), createdProduct.getVnama_barang());    
    }
    
    
    @Test
    public void testUpdateProduct() 
    {
        long timestamp = System.currentTimeMillis();
        Product product = productService.findById(3);
        product.setVnama_barang("Product-"+timestamp);
        int i = productService.updateProduct(product);
        Assert.assertTrue(i > 0);
        System.out.println("updated product : " +product.getVnama_barang());
        Product updatedProduct = productService.findById(3);
        Assert.assertEquals(product.getVnama_barang(), updatedProduct.getVnama_barang());    
   
    }

    @Test
    public void testFindAllProduct() {
        EventList<Product> list = new BasicEventList<>();
        try {
            list.getReadWriteLock().writeLock().lock();
            int rec = 0;
            List productAll = productService.findAll();
            for (Iterator it = productAll.iterator(); it.hasNext();) {
                rec = rec + 1;
                Product prd = (Product) it.next();
                System.out.println("produk : " + prd.getVnama_barang());
                // list.add(getListProduct(prd.getId(), prd.getCbarang(), prd.getVnama_barang(), prd.isBanalisa(), prd.isBreduct(), prd.isBtipe(), prd.isBaktif(), rec));
            }
        } finally {
            list.getReadWriteLock().writeLock().unlock();
        }
    }
    
    
    @Test
    public void testDeleteProduct() 
    {
        Product product = productService.findById(5);
        Assert.assertNotNull("Product return null",product);
        productService.delete(product.getId());
        Product deletedProduct = productService.findById(5);
        Assert.assertNull(deletedProduct);
        System.out.println("produk : " + product.getVnama_barang()+" Deleted.");
    }
    
    
}
