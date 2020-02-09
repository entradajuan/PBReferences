package com.needine.pbreferences;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.needine.pbreferences.domain.Reference;
import com.needine.pbreferences.repository.ReferenceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReferenceRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ReferenceRepository referenceRepository;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    public void whenFindById_thenReturnReference() {
        
    	// given
        Reference r1 = new Reference("UK", "000001");
        entityManager.persist(r1);
        entityManager.flush();
     
        // when
        Reference found = referenceRepository.findByName(r1.getName());
     
        // then
        assertThat(found.getName())
          .isEqualTo(r1.getName());
        
    }

}
