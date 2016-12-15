package com.foo2.web;
import com.foo2.domain.Timer;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = TimersCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Timer.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class TimersCollectionJsonController {
}