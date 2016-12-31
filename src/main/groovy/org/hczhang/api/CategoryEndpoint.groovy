package org.hczhang.api

import ratpack.groovy.handling.GroovyChainAction
import ratpack.jackson.Jackson
import ratpack.registry.Registry

/**
 * Created by steven on 30/12/2016.
 */
class CategoryEndpoint extends GroovyChainAction {

    @Override
    void execute() throws Exception {

        path {
            byMethod {
                get {
                    render "GET /category"
                }
                post {
                    render "POST /category"
                }
            }
        }

        prefix(":id") {
            all {
                Category c = new Category(id: 1, name: "toy")
                next(Registry.single(c))
            }

            path {
                byMethod { ctx ->
                    def c = get(Category)

                    get {
                        // the following code will throws exception.
                        // java.lang.IllegalStateException: delegate requested outside of execute

                        // get(Category)
                        render Jackson.json(c)
                    }

                }
            }
        }
    }
}
