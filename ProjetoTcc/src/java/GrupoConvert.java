
import br.com.controle.virtual.entity.Exercicio;
import br.com.controle.virtual.entity.GrupoMuscular;
import br.com.controle.virtual.entity.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "GrupoConvert", forClass = GrupoMuscular.class)
public class GrupoConvert implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            if (uiComponent.getAttributes().get(value) instanceof GrupoMuscular) {
                return (GrupoMuscular) uiComponent.getAttributes().get(value);
            } else if (uiComponent.getAttributes().get(value) instanceof Usuario) {
                return (Usuario) uiComponent.getAttributes().get(value);
            } else if (uiComponent.getAttributes().get(value) instanceof Exercicio) {
                return (Exercicio) uiComponent.getAttributes().get(value);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof GrupoMuscular) {
            GrupoMuscular entity = (GrupoMuscular) value;
            if (entity != null && entity instanceof GrupoMuscular && entity.getId() != null) {
                uiComponent.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        } else {
            if (value instanceof Usuario) {
                Usuario entity = (Usuario) value;
                if (entity != null && entity instanceof Usuario && entity.getId() != null) {
                    uiComponent.getAttributes().put(entity.getId().toString(), entity);
                    return entity.getId().toString();
                }
            } else {
                if (value instanceof Exercicio) {
                    Exercicio entity = (Exercicio) value;
                    if (entity != null && entity instanceof Exercicio && entity.getId() != null) {
                        uiComponent.getAttributes().put(entity.getId().toString(), entity);
                        return entity.getId().toString();
                    }
                }
            }
        }
        return "";
    }
}
