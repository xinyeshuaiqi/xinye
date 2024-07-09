package pers.wmx.springbootfreemarkerdemo.util.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @author wangmingxin03
 * Created on 2024-07-09
 */
public class TestComparator {
    public static void main(String[] args) {
        List<UserModel> users = Lists.newArrayList();
        sortUser(users);
    }

    private static List<UserModel> sortUser(List<UserModel> users) {
        return users.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(UserModel::getUpdateTime, Comparator.reverseOrder())
                        .thenComparing(UserModel::getCreateTime)
                        .thenComparing(UserModel::getLoginTime, Comparator.reverseOrder())
                ).collect(Collectors.toList());
    }
}
