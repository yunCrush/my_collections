package yun.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: yunCrush
 * Date:2022-09-02 10:28
 * Description: 用户信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    public String name;
    public int age;

}
