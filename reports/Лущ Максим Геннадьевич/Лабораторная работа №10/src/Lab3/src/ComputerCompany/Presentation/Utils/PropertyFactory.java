package ComputerCompany.Presentation.Utils;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;

import java.util.function.Function;

public class PropertyFactory {
    public static <S, T> SimpleObjectProperty<T> CreateProperty(
            TableColumn.CellDataFeatures<S, T> cell,
            Function<S, T> targetValueGetter)
    {
        var targetValue = targetValueGetter.apply(cell.getValue());
        var result = new SimpleObjectProperty<>(targetValue);
        return result;
    }
}
