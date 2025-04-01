package edu.tienda.core.controllers;


import edu.tienda.core.domain.Cliente;
import edu.tienda.core.services.ClienteRenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


@RestController
public class ClienteRenderController {

    @Autowired
    private ClienteRenderService clienteRenderService;

    @GetMapping(value = "/clientes-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClienteAsHtml(){
        return clienteRenderService.generarHtmlCliente();
    }

    @GetMapping(value = "/clientes-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getClienteAsXml() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            Cliente cliente = new Cliente("Cosme", "Fulanito");
            return xmlMapper.writeValueAsString(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return "<error>Failed to generate XML</error>";
        }
    }
}
