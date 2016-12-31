import org.hczhang.api.CategoryEndpoint
import org.hczhang.api.CategoryModule

import static ratpack.groovy.Groovy.ratpack

/**
 * Created by steven on 30/12/2016.
 */

ratpack {
    bindings {
        module(CategoryModule)
    }

    handlers { CategoryEndpoint categoryEndpoint->
        prefix("category", categoryEndpoint)
    }
}