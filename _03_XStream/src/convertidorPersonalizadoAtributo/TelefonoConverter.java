package convertidorPersonalizadoAtributo;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class TelefonoConverter implements SingleValueConverter {
    @Override
    public String toString(Object o) {
        //return new Integer(((Telefono) o).getNumero()).toString();
        Telefono telefono = (Telefono) o;
        return "+" + telefono.getCodigo() + " " + telefono.getNumero();
    }

    @Override
    public Object fromString(String s) {
        Telefono tel = new Telefono();
        //tel.setNumero(new Integer(s));
        //return tel;
        String codigo = s.substring(1, s.indexOf(' '));
        String numero = s.substring(s.indexOf(' ')+1);
        tel.setCodigo(Integer.parseInt(codigo));
        tel.setNumero(Integer.parseInt(numero));
        return tel;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Telefono.class);
    }
}


