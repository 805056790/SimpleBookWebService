package graduation.hnust.simplebook.user.enums;

import com.google.common.base.Objects;

/**
 * Author  : panxin
 * Date    : 9:06 PM 3/26/16
 */
public enum Gender {

    BOY(1,"男"),
    GIRL(2,"女");

    private final int value;

    private final String desc;

    Gender(int number, String desc) {
        this.value = number;
        this.desc = desc;
    }

    public int value(){
        return this.value;
    }

    public static Gender from(int value) {
        for (Gender gender : Gender.values()) {
            if (Objects.equal(gender.value, value)) {
                return gender;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
