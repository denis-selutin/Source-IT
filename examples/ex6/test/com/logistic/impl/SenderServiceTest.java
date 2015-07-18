package com.logistic.impl;

import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.SenderService;
import com.logistic.impl.model.person.Address;
import com.logistic.impl.model.person.Person;
import com.logistic.impl.service.SenderServiceImpl;
import com.logistic.impl.service.StorageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StorageHelper.class)
public class SenderServiceTest {
    public static PostOffice TEST_POST_1 = new com.logistic.impl.model.post.PostOffice(new Address("Test 1", "City 1", "Country 1", 0), Package.Type.T_30, 30, new Point(0, 0));
    public static PostOffice TEST_POST_2 = new com.logistic.impl.model.post.PostOffice(new Address("Test 2", "City 2", "Country 1", 1), Package.Type.T_10, 60, new Point(2, 3));
    public static PostOffice TEST_POST_3 = new com.logistic.impl.model.post.PostOffice(new Address("Test 3", "City 3", "Country 1", 2), Package.Type.T_27, 45, new Point(5, 6));
    public static PostOffice TEST_POST_4 = new com.logistic.impl.model.post.PostOffice(new Address("Test 4", "City 3", "Country 1", 3), Package.Type.T_10, 35, new Point(10, 23));
    public static PostOffice TEST_POST_5 = new com.logistic.impl.model.post.PostOffice(new Address("Test 5", "City 3", "Country 1", 4), Package.Type.T_CP, 60, new Point(45, 6));

    public static final List<PostOffice> OFFICES = Arrays.asList(TEST_POST_1, TEST_POST_2, TEST_POST_3);
    public static final List<Transit> TRANSITS = Arrays.asList(
            new com.logistic.impl.model.transport.Transit(Arrays.asList(
                    TEST_POST_1, TEST_POST_2), 89),
            new com.logistic.impl.model.transport.Transit(Arrays.asList(
                    TEST_POST_1, TEST_POST_4, TEST_POST_5, TEST_POST_3, TEST_POST_2), 1029),

            new com.logistic.impl.model.transport.Transit(Arrays.asList(
                    TEST_POST_1, TEST_POST_2, TEST_POST_3), 86),
            new com.logistic.impl.model.transport.Transit(Arrays.asList(
                    TEST_POST_1, TEST_POST_4, TEST_POST_5, TEST_POST_3), 50)
            );

    @Test
    public void testGetAllOffices(){
        PowerMockito.mockStatic(StorageHelper.class);
        PowerMockito.when(StorageHelper.getAllOffices()).thenReturn(OFFICES);

        SenderService service = new SenderServiceImpl();
        List<PostOffice> offices = service.getAllOffices();

        PowerMockito.verifyStatic(Mockito.times(1));
        assert(offices.size() == 3);
        assert(offices.get(0).getAcceptableTypes() == Package.Type.T_30);
        assert(offices.get(0).getMaxWeight() == 30);
    }

    @Test
    public void testCalculatePossibleTransitsForSeveralAppropriateTransits() {
        PowerMockito.mockStatic(StorageHelper.class);
        PowerMockito.when(StorageHelper.getAllOffices()).thenReturn(OFFICES);
        PowerMockito.when(StorageHelper.getTransits()).thenReturn(TRANSITS);
        Package parcel = new com.logistic.impl.model.post.Package(10,
                Package.Type.T_10,
                new Person.PersonBuilder().firstName("f1").lastName("l1").middleName("m1").address(TEST_POST_1.getAddress()).build(),
                new Person.PersonBuilder().firstName("f2").lastName("l2").middleName("m2").address(TEST_POST_2.getAddress()).build());


        SenderService service = new SenderServiceImpl();
        List<Transit> transits = service.calculatePossibleTransits(parcel);

        assert(transits.size() == 2);
        assert(transits.get(0).getPrice() == 89);
    }

    @Test
    public void testCalculatePossibleTransitsForOverweightParcel() {
        PowerMockito.mockStatic(StorageHelper.class);
        PowerMockito.when(StorageHelper.getAllOffices()).thenReturn(OFFICES);
        PowerMockito.when(StorageHelper.getTransits()).thenReturn(TRANSITS);
        Package parcel = new com.logistic.impl.model.post.Package(90,
                Package.Type.T_10,
                new Person.PersonBuilder().firstName("f1").lastName("l1").middleName("m1").address(TEST_POST_1.getAddress()).build(),
                new Person.PersonBuilder().firstName("f2").lastName("l2").middleName("m2").address(TEST_POST_2.getAddress()).build());


        SenderService service = new SenderServiceImpl();
        List<Transit> transits = service.calculatePossibleTransits(parcel);

        System.out.println(transits);
        assert(transits.size() == 0);
    }
}
