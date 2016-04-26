package bg.jug.website.config;

import org.apache.deltaspike.data.api.EntityManagerResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ivan St. Ivanov
 */
public class WebsiteEntityManagerResolver implements EntityManagerResolver {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }
}
