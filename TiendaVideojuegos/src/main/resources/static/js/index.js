const btnCart = document.querySelector('.container-icon');
const containerCartProducts = document.querySelector('.container-cart-products');

let total_compra=0;
let contador_prod = 0;

btnCart.addEventListener('click', () => {
    containerCartProducts.classList.toggle('hidden-cart');
});


var eliminar = document.getElementById("eliminar");
eliminar.onclick = function() {
    containerCartProducts.removeChild;
}

// CARRITO
// Obtener todos los botones "Añadir al carrito"
const addToCartButtons = document.querySelectorAll('.add-to-cart-btn');

// Escuchar el evento de clic en cada botón "Añadir al carrito"
addToCartButtons.forEach(button => {
    button.addEventListener('click', () => {
         // Obtener la información del producto asociado a este botón
        const productInfoContainer = button.closest('.info-product');
        const productName = productInfoContainer.querySelector('h2').textContent;
        const productPrice = productInfoContainer.querySelector('.price').textContent;
        const productoPrecio = parseInt(productInfoContainer.querySelector('.price').textContent.replace('€', ''), 10);
        total_compra+= productoPrecio;
        contador_prod+=1;
        const totalPagarElement = document.querySelector('.total-pagar');
            totalPagarElement.textContent = `$${total_compra}`;
        document.getElementById('contador-productos').textContent = contador_prod;

        


        // Crear un nuevo elemento para representar el producto en el carrito
        const cartProduct = document.createElement('div');
        cartProduct.classList.add('cart-product');

        // Agregar la información del producto al elemento del carrito
        cartProduct.innerHTML = `
            <div class="info-cart-product">
                <span class="cantidad-producto-carrito">1</span>
                <p class="titulo-producto-carrito">${productName}</p>
                <span class="precio-producto-carrito">${productPrice}</span>
            </div>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="icon-close">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12"/>
            </svg>`;

        // Agregar el elemento del producto al contenedor del carrito, encima del total y debajo del último producto
        const totalElement = document.querySelector('.cart-total');
        containerCartProducts.insertBefore(cartProduct, totalElement);

        // Obtener el botón "Eliminar producto" dentro del elemento del producto del carrito
        const deleteButton = cartProduct.querySelector('.icon-close');

        // Escuchar el evento de clic en el botón "Eliminar producto"
deleteButton.addEventListener('click', () => {
    // Eliminar el elemento del producto del carrito
    containerCartProducts.removeChild(cartProduct);
    total_compra -= productoPrecio;
    const totalPagarElement = document.querySelector('.total-pagar');
    totalPagarElement.textContent = `$${total_compra}`;

    contador_prod -= 1;
    document.getElementById('contador-productos').textContent = contador_prod;
});

    });
});

// Obtener el botón "Comprar"
const submitButton = document.getElementById("submit");

// Escuchar el evento de clic en el botón "Comprar"
submitButton.addEventListener('click', () => {
    // Obtener los productos seleccionados
    const products = [];
    const cartProducts = document.querySelectorAll('.cart-product');
    cartProducts.forEach(cartProduct => {
        const productName = cartProduct.querySelector('.titulo-producto-carrito');
        const productPrice = cartProduct.querySelector('.precio-producto-carrito');
        if (productName && productPrice) {
            products.push({ name: productName.textContent, price: productPrice.textContent });
        }
    });

    // Codificar los productos como JSON y pasarlos como parámetro de consulta en la URL
    const encodedProducts = encodeURIComponent(JSON.stringify(products));
    // Redirigir a pago.php en la carpeta correspondiente
    window.location.href = `http://localhost:8080/Tienda-de-videojuegos/TiendaVideojuegos/src/main/resources/static/php/pago.php?products=${encodedProducts}`;
});
