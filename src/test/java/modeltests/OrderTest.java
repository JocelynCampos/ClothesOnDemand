package modeltests;

import commands.GarmentCommandPipeline;
import models.*;
import org.junit.jupiter.api.Test;
import utilities.Events;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void orderTest() {

        Customer customer = new Customer("Test Testsson");
        Pants pants = new Pants();
        TShirt tShirt = new TShirt();
        Skirt skirt = new Skirt();

        pants.setPrice(10);
        tShirt.setPrice(20);
        skirt.setPrice(30);

        Order order = new Order(customer, List.of(pants), List.of(tShirt), List.of(skirt));

        List<String> event = new ArrayList<>();
        order.addPropertyChangeListener(evt -> event.add(evt.getPropertyName()));

        int oldId = order.getId();
        order.setId(oldId + 1);
        order.setPlacedOrderStatus(order.getPlacedOrderStatus());
        order.setCustomer(order.getCustomer());
        Order.setCounter(Order.getCounter());

        order.placeOrder();
        order.producingGarment(pants);


        GarmentCommandPipeline testPipe = new GarmentCommandPipeline();
        testPipe.addCommand(garment -> {});
        order.garmentFinished(pants, testPipe);

        order.completedOrder();

        List<Garments> allGarments = order.getAllGarments();
        Receipt receipt = order.createReceipt();

        assertEquals(3, allGarments.size());
        assertNotNull(receipt);
        assertTrue(event.contains(Events.PLACED_ORDER));
        assertTrue(event.contains(Events.PRODUCING_GARMENT));
        assertTrue(event.contains(Events.GARMENT_FINISHED));
        assertTrue(event.contains(Events.ORDER_FINISHED));

    }
}
