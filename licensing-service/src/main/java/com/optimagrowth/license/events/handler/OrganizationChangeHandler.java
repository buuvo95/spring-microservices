package com.optimagrowth.license.events.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optimagrowth.license.events.model.OrganizationChangeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OrganizationChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationChangeHandler.class);

    @Bean
    public Consumer<OrganizationChangeModel> organizationChanges() {
        return organization -> {
            logger.debug("Received a message of type " + organization.getType());

            switch(organization.getAction()){
                case "GET":
                    logger.debug("Received a GET event from the organization service for organization id {}", organization.getOrganizationId());
                    break;
                case "SAVE":
                    logger.debug("Received a SAVE event from the organization service for organization id {}", organization.getOrganizationId());
                    break;
                case "UPDATE":
                    logger.debug("Received an UPDATE event from the organization service for organization id {}", organization.getOrganizationId());
                    break;
                case "DELETE":
                    logger.debug("Received a DELETE event from the organization service for organization id {}", organization.getOrganizationId());
                    break;
                default:
                    logger.error("Received an UNKNOWN event from the organization service of type {}", organization.getType());
                    break;
            }
        };
    }


}
