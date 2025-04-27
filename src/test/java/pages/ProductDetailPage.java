package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    //Links Localizador
    By specificItemLink_Locator = By.xpath(
            "img[contains(@src,'https://images.squarespace-cdn.com/content/v1/624b503d84c2ba7dc187a92a/1649102915554-HKBHY3P2SYVIXVMQA7ZX/ulihu-blue-linen-tunic_0308-v1-FINAL-copy.jpg')]");

    //Product data Localizador
    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By selectSize_Locator = By.cssSelector("*[class='variant-select-wrapper', data-text='Select Size']");
    By quantityItem_Locator = By.cssSelector("*[class='quantity-label']");
    By inputQuantitySelectorItem_Locator = By.cssSelector("input[aria-label='Quantity']");
    By bottonAddToCart = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");

/*Localizadores de la profe

    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By productPrice_Locator = By.cssSelector("div.product-price");
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");

 */



    //Constructor de la clase
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    //Método para seleccionar talla, cantidad (recibimos talla y cant como parámetros)
    // Hacer click en el btn Add to Cart y
    //Verificar que el número del carrito aumenta en la cantidad de elementos que añadimos

    //Tarea
    //1- Crear Método que retorne el título del producto
    //2- Crear Método que retorne el precio del producto

}
