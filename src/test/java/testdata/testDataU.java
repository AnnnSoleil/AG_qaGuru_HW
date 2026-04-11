package testdata;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromStringArray;
import static utils.RandomUtils.getRandomPhone;
import static utils.RandomUtils.getRandomString;

public class testDataU {
    public String firstNameU = getRandomString(10),
            lastNameU = getRandomString(10),
            userEmailU = getRandomEmail(),
            genderU = getRandomGender(),
            userNumberU = getRandomPhone(),
            dayForSelectorU = String.format("%03d", getRandomInt(1,28)),
            monthU = getRandomItemFromStringArray(new String[]{
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            }),
            yearU = String.valueOf(getRandomInt(1950,2005)),
            subjectU = getRandomItemFromStringArray(new String[]{"Maths", "Physics", "English"}),
            hobbyU = getRandomItemFromStringArray(new String[]{"Sports", "Reading", "Music"}),
            currentAddressU = getRandomString(100),
            stateU = "NCR",
            stateCityU = getRandomItemFromStringArray(new String[]{"Delhi", "Gurgaon", "Noida"});
}
