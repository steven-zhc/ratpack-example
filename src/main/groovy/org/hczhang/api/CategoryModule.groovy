package org.hczhang.api

import com.google.inject.AbstractModule
import com.google.inject.Scopes

/**
 * Created by steven on 30/12/2016.
 */
class CategoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CategoryEndpoint).in(Scopes.SINGLETON)
    }
}
