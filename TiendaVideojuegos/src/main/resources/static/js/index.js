const btnCart = document.querySelector('.container-icon');
const containerCartProducts = document.querySelector('.container-cart-products');

let totalCompra = 0;
let contadorProd = 0;

btnCart.addEventListener('click', () => {
    containerCartProducts.classList.toggle('hidden-cart');
});

// Obtener todos los botones "Añadir al carrito"
const addToCartButtons = document.querySelectorAll('.add-to-cart-btn');

addToCartButtons.forEach(button => {
    button.addEventListener('click', () => {
        const productInfoContainer = button.closest('.info-product');
        const productName = productInfoContainer.querySelector('h2').textContent;
        const productPrice = parseInt(productInfoContainer.querySelector('.price').textContent.replace('€', ''));

        totalCompra += productPrice;
        contadorProd++;

        const totalPagarElement = document.querySelector('.total-pagar');
        if (totalPagarElement) {
            totalPagarElement.textContent = `$${totalCompra.toFixed(2)}`;
        }

        const contadorProductosElement = document.getElementById('contador-productos');
        if (contadorProductosElement) {
            contadorProductosElement.textContent = contadorProd;
        }

        const cartProduct = document.createElement('div');
        cartProduct.classList.add('cart-product');

        cartProduct.innerHTML = `
            <div class="info-cart-product">
                <span class="cantidad-producto-carrito">1</span>
                <p class="titulo-producto-carrito">${productName}</p>
                <span class="precio-producto-carrito">${productPrice.toFixed(2)}€</span>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="icon-close">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"/>
            </svg>`;

        const totalElement = document.querySelector('.cart-total');
        containerCartProducts.insertBefore(cartProduct, totalElement);

        const deleteButton = cartProduct.querySelector('.icon-close');

        deleteButton.addEventListener('click', () => {
            containerCartProducts.removeChild(cartProduct);
            totalCompra -= productPrice;
            if (totalPagarElement) {
                totalPagarElement.textContent = `$${totalCompra.toFixed(2)}`;
            }
            contadorProd--;
            if (contadorProductosElement) {
                contadorProductosElement.textContent = contadorProd;
            }
        });
    });
});

const submitButton = document.getElementById("submit");

submitButton.addEventListener('click', () => {
    const products = [];

    const cartProducts = document.querySelectorAll('.cart-product');
    cartProducts.forEach(product => {
        const productNameElement = product.querySelector('.titulo-producto-carrito');
        const productPriceElement = product.querySelector('.precio-producto-carrito');
        const productQuantityElement = product.querySelector('.cantidad-producto-carrito');
        
        if (productNameElement && productPriceElement && productQuantityElement) {
            const productName = productNameElement.textContent;
            const productPrice = parseFloat(productPriceElement.textContent.replace('€', ''));
            const productQuantity = parseInt(productQuantityElement.textContent);
            products.push({ name: productName, price: productPrice, quantity: productQuantity });
        }
    });

    fetch('/tienda/comprar/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(products)
    }).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    }).then(data => {
        console.log(data);
    }).catch(error => {
        console.error('Error:', error);
    });
});    

document.getElementById("alta").addEventListener("click", function(){
    window.location.href = "alta.html";
});
