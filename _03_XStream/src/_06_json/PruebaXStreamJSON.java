package _06_json;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class PruebaXStreamJSON {

    public static void main(String[] args) {
        Producto producto = new Producto(12, "Banana", new Float(23.00));
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.alias("product", Producto.class);
        System.out.println(xstream.toXML(producto));
    }
}

