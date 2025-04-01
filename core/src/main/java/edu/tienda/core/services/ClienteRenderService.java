package edu.tienda.core.services;

import org.springframework.stereotype.Service;

@Service
public class ClienteRenderService {
    public String generarHtmlCliente() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<body>")
                .append("<div><h1>Cliente</h1>")
                .append("<ul>")
                .append("<li>Nombre: Cosme Fulanito</li>")
                .append("<li>Username: CFL</li>")
                .append("</ul>")
                .append("</div>")
                .append("</body>")
                .append("</html>");
        return sb.toString();
    }

    public String getClienteAsXml(){

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<cliente>");
        sb.append("<nombre>Nombre: Cosme Fulanito</nombre>");
        sb.append("<username>Username: Cosme Fulanito</username>");
        sb.append("</cliente>");
        sb.append("</xml>");
        return sb.toString();
    }

}
