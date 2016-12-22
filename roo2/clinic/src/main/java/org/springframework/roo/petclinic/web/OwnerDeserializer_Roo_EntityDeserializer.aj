// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.springframework.roo.petclinic.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.web.OwnerDeserializer;

privileged aspect OwnerDeserializer_Roo_EntityDeserializer {
    
    declare @type: OwnerDeserializer: @JsonComponent;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Owner
     * @throws IOException
     */
    public Owner OwnerDeserializer.deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Owner owner = ownerService.findOne(id);
        if (owner == null) {
            throw new NotFoundException("Owner not found");
        }
        return owner;
    }
    
}
