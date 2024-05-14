<?php
// Verificar si se pasaron los productos como parámetro de consulta en la URL
if (isset($_GET['products'])) {
    // Decodificar los productos JSON de forma segura
    $encodedProducts = $_GET['products'];
    $products = json_decode(urldecode($encodedProducts), true);

    // Mostrar los productos de manera más legible y segura
    if (!empty($products) && is_array($products)) {
        echo "<h2>Detalles de la compra:</h2>";
        echo "<ul>";
        foreach ($products as $product) {
            $productName = htmlspecialchars($product['name']); // Escapar caracteres HTML especiales para mayor seguridad
            $productPrice = htmlspecialchars($product['price']);
            echo "<li>{$productName} - {$productPrice}</li>";
        }
        echo "</ul>";
    } else {
        echo "<p>No se han encontrado productos.</p>";
    }
} else {
    echo "<p>No se han pasado productos como parámetro de consulta en la URL.</p>";
}
?>
