package br.com.lojagames.Interface.RestController;

import br.com.lojagames.InfraStructure.CrossCutting.Injactor;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author Victor
 */
public class AplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        Injactor.services(this);
        Injactor.repository(this);
        Injactor.model(this);
        Injactor.entity(this);
    }

}
