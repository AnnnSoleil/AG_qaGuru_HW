package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Cat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonTests {
    private ClassLoader cl = ZipTests.class.getClassLoader();

    @Test
    void jsonParsingTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(
                cl.getResourceAsStream("files/cat.json"),
                Cat.class
        );
        assertThat(cat.objectCat).isEqualTo("Cat");
        assertThat(cat.nameCat).isEqualTo("Musya");
        assertThat(cat.ageCat).isEqualTo(2);
        assertThat(cat.skillsCat.get(1)).contains("eat");
        assertThat(cat.address.city).isEqualTo("Moscow");

    }
}
