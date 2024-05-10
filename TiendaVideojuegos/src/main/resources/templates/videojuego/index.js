const btnCart = document.querySelector('.container-icon');
const containerCartProducts = document.querySelector('.container-cart-products');

let total_compra=0;

btnCart.addEventListener('click', () => {
    containerCartProducts.classList.toggle('hidden-cart');
});

var boton = document.getElementById("submit");
boton.onclick = function() {
    alert("¡Has hecho clic en el botón!");
};

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
        const productoPrecio = parseInt(productInfoContainer.querySelector('.price').textContent.replace('$', ''), 10);
        total_compra+= productoPrecio;
        const totalPagarElement = document.querySelector('.total-pagar');
            totalPagarElement.textContent = `$${total_compra}`;

        


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
            total_compra-=productoPrecio;
            const totalPagarElement = document.querySelector('.total-pagar');
            totalPagarElement.textContent = `$${total_compra}`;
        });
    });
});

// Escuchar el evento de clic en el botón "Comprar"
const submitButton = document.getElementById("submit");
submitButton.addEventListener('click', () => {
    alert("¡Has hecho clic en el botón de comprar!");
});
