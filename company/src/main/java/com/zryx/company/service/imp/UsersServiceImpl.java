package com.zryx.company.service.imp;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.UsersMapper;
import com.zryx.company.model.Users;
import com.zryx.company.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    private PageConfig<Users> pageConfig;

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = usersMapper.getAllUsers();
        return users;
    }

    @Override
    public void delUsers(int id) {
        int row = usersMapper.delUsers(id);
        if(row == 0) {
            throw new CustomException(100,"删除用户出现异常");
        }
    }

    @Override
    public void addUsers(Users users) {
        int row = usersMapper.addUsers(users);
        if(row ==0){
            throw new CustomException(100,"添加用户出现异常");
        }
    }

    /**
     * 登录验证
     * 返回3为找不到账号
     * 返回2为不是管理员
     * 返回1为密码不正确
     * 返回为0登录成功
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public int loginInspection(String userName, String password) {
        if(usersMapper.getPasswordByUserName(userName)==null)
            return 3;
        int status = usersMapper.getStatusByUserName(userName);
        if(!password.equals(usersMapper.getPasswordByUserName(userName)))
            return 1;
        else if (status != 1)return 2;
        else return 0;
    }

    @Override
    public Users login(String userName, String password) {
        Users user = usersMapper.getUserByName(userName);
        if(user!=null) {
            if(user.getPassword().equals(password)) {
                return user;
            }else {
                throw new CustomException(2000,"用户名或密码错误");
            }
        }
        return null;
    }


    @Override
    public void updUsers(Users users) {
        int row = usersMapper.updUsers(users);
        if(row == 0) {
            throw new CustomException(100,"修改用户信息出现异常");
        }
    }


    @Override
    public Users getUserByName(String name) {
        Users users = usersMapper.getUserByName(name);
        return users;
    }

    /*@Override
    public Users getUserById(int id) {
        Users users = usersMapper.getUserById("name");
        return users;
        return null;
    }*/
    @Override
    public PageConfig<Users> getUsersByPage(int page) {
        //设置当前页
        pageConfig.setPageNum(page);
        //得到从哪开始查询
        int from = (page - 1) * pageConfig.pageSize;
        //得到查几条
        int size = pageConfig.pageSize;
        //查出当前页的数据
        List<Users> users = usersMapper.getUsersByPage(from,size);
        //设置当前页
        pageConfig.setPageData(users);
        //得到总数据量
        int count = usersMapper.dataCount();
        //设置一共有几条数据
        pageConfig.setDataCount(count);
        //返回包含当前页的数据、当前页、总页数、总记录数的一个对象
        return pageConfig;
    }

}
