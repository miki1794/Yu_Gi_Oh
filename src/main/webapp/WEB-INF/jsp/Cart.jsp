
<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.ItemOrdine" %>
<%@ page import="Model.Bean.Carta" %>
<%@ page import="Model.Dao.CartaDao" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carrello</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/Cart.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container_cart">

    <h1>Carrello</h1>

    <ul>
        <%
            List<ItemOrdine> cart = (List<ItemOrdine>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
                CartaDao cartaDao = new CartaDao();
                for (ItemOrdine orderItems : cart) {

                    Carta carta = cartaDao.doRetrievebyID(Integer.parseInt(orderItems.getNomeCarta()));
        %>
        <li>
            <%
                String imgPath = carta.getLink();
                String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
            %>
            <div class="image">
                <img src="<%= imgSrc %>" alt="Immagine Carta">
            </div>
            <div class="description">
                <a href="Prodotto?id=<%= carta.getId() %>">
                    <strong><%= carta.getNome() %></strong>

                </a>
                <p>Prezzo: </p>&euro;<%= orderItems.getPrezzo() %>
                <form action="Cart" method="POST">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="cartaId" value="<%= carta.getId() %>">


                    <label for="quantity_<%= carta.getId() %>">Quantit&agrave;:</label>
                    <input type="number" name="quantity" value="<%= orderItems.getQuantita() %>" min="1" max="100" tabindex="0" id="quantity_<%= carta.getId() %>">

                    <input type="submit" value="Aggiorna">
                </form>
            </div>
            <div class="remove">
                <form action="Cart" method="POST">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="cartaId" value="<%= carta.getId() %>">
                    <input type="image" src="./assets/cestino.png" alt="Rimuovi">
                </form>
            </div>
        </li>
        <%}
        }%>
    </ul>

    <div class="acquisti">

        <% if (cart != null && !cart.isEmpty()) { %>

        <div class="procedere">
            <a href=CartOrder>Procedi con l'acquisto</a>
        </div>

        <% } else %>  <p>Carrello Vuoto</p>

        <div class="continua">
            <a href="ListaProdotti">Continua lo shopping</a>
        </div>

    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>