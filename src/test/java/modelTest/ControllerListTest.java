package modelTest;

import model.Nodo;
import org.junit.Test;
import org.junit.Before;
import model.ControllerList;
import org.junit.Assert;
public class ControllerListTest {
    private ControllerList controller;
    @Before
    public void setupStage1() {
        controller = new ControllerList();
        controller.addNodos(-1,"a");
        controller.addNodos(20,"b");
        controller.addNodos(5,"c");
        controller.addNodos(13,"d");
        controller.addNodos(17,"e");
        controller.addNodos(9,"f");
        controller.addNodos(2,"g");
        controller.addNodos(-6,"h");
        controller.addNodos(2,"i");
        controller.addNodos(13,"j");
    }

    @Test
    public void testOrdenamientoSeleccion() throws Exception {
        controller.ordenamientoSeleccion();
        String expectedText = controller.toStringList();

        Assert.assertEquals("-6.0, -1.0, 2.0, 2.0, 5.0, 9.0, 13.0, 13.0, 17.0, 20.0", expectedText);

    }
}