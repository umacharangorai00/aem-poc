package com.micron.web.core.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.micron.web.core.constants.TestConstants;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({AemContextExtension.class, MockitoExtension.class })
public class DynamicComponentModelTest {

    private final AemContext aemContext = new AemContext();
    private static DynamicComponentModel dynamicComponentModel;

    @BeforeEach
    void setUp() {
        this.aemContext.addModelsForClasses(DynamicComponentModel.class);
        this.aemContext.load().json(TestConstants.DYNAMIC_COMPONENT_PATH +"dynamicComponent.json", "/component");
        this.dynamicComponentModel = this.aemContext.currentResource("/component/dynamic_component").adaptTo(DynamicComponentModel.class);
    }

    @Test
    void testDynamicComponent() {

        assertAll(

                  () -> assertNotNull(this.dynamicComponentModel.getProductType()),
                  () -> assertEquals("laptop", this.dynamicComponentModel.getProductType()),
                  () -> assertNotNull(this.dynamicComponentModel.getResolution()),
                  () -> assertEquals("hd", this.dynamicComponentModel.getResolution()),
                  () -> assertNotNull(this.dynamicComponentModel.getKeyboardLayout()),
                  () -> assertEquals("qwertz", this.dynamicComponentModel.getKeyboardLayout()),
                  () -> assertNotNull(this.dynamicComponentModel.getOperatingSystem()),
                  () -> assertEquals("laptop", this.dynamicComponentModel.getOperatingSystem()),
                  () -> assertNotNull(this.dynamicComponentModel.isSupportHdr()),
                  () -> assertEquals(false, this.dynamicComponentModel.isSupportHdr()),
                  () -> assertNotNull(this.dynamicComponentModel.getScreenSize()),
                  () -> assertEquals("14", this.dynamicComponentModel.getScreenSize())
        );

    }

}
