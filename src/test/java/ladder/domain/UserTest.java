package ladder.domain;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserTest {
    public static final int CREATED_NAME_NUM = 100;
    public static Faker faker = new Faker();
    public static Random random = new Random();
    public static List<String> validate_names;
    public static List<String> invalidate_names;

    @BeforeAll
    static void createSampleNames() {
        final int FAKE_NAME_MAX_LEN = 7;
        Map<Boolean, List<String>> namesPartition = IntStream.range(0, CREATED_NAME_NUM)
                .mapToObj(e -> faker.name().name().substring(0, random.nextInt(FAKE_NAME_MAX_LEN)))
                .collect(Collectors.partitioningBy(name -> name.length() <= User.MAX_NAME_LEN));
        validate_names = namesPartition.get(true);
        invalidate_names = namesPartition.get(false);
    }

    @Test
    @DisplayName("유저 생성 테스트")
    void createUser() {
        validate_names.forEach(name -> Assertions.assertInstanceOf(User.class, new User(name)));
        invalidate_names.forEach(name -> Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new User(name)));
    }

}
