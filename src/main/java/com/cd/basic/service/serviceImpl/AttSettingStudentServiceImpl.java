package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttSettingStudentDao;
import com.cd.basic.pojo.domain.AttSettingStudent;
import com.cd.common.Assist;
import com.cd.basic.service.AttSettingStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttSettingStudentServiceImpl implements AttSettingStudentService{
    @Autowired
    private AttSettingStudentDao attSettingStudentDao;
    @Override
    public long getAttSettingStudentRowCount(Assist assist){
        return attSettingStudentDao.getAttSettingStudentRowCount(assist);
    }
    @Override
    public List<AttSettingStudent> selectAttSettingStudent(Assist assist){
        return attSettingStudentDao.selectAttSettingStudent(assist);
    }
    @Override
    public AttSettingStudent selectAttSettingStudentByObj(AttSettingStudent obj){
        return attSettingStudentDao.selectAttSettingStudentByObj(obj);
    }
    @Override
    public AttSettingStudent selectAttSettingStudentById(Long id){
        return attSettingStudentDao.selectAttSettingStudentById(id);
    }
    @Override
    public int insertAttSettingStudent(AttSettingStudent value){
        return attSettingStudentDao.insertAttSettingStudent(value);
    }
    @Override
    public int insertNonEmptyAttSettingStudent(AttSettingStudent value){
        return attSettingStudentDao.insertNonEmptyAttSettingStudent(value);
    }
    @Override
    public int insertAttSettingStudentByBatch(List<AttSettingStudent> value){
        return attSettingStudentDao.insertAttSettingStudentByBatch(value);
    }
    @Override
    public int deleteAttSettingStudentById(Long id){
        return attSettingStudentDao.deleteAttSettingStudentById(id);
    }
    @Override
    public int deleteAttSettingStudent(Assist assist){
        return attSettingStudentDao.deleteAttSettingStudent(assist);
    }
    @Override
    public int updateAttSettingStudentById(AttSettingStudent enti){
        return attSettingStudentDao.updateAttSettingStudentById(enti);
    }
    @Override
    public int updateAttSettingStudent(AttSettingStudent value, Assist assist){
        return attSettingStudentDao.updateAttSettingStudent(value,assist);
    }
    @Override
    public int updateNonEmptyAttSettingStudentById(AttSettingStudent enti){
        return attSettingStudentDao.updateNonEmptyAttSettingStudentById(enti);
    }
    @Override
    public int updateNonEmptyAttSettingStudent(AttSettingStudent value, Assist assist){
        return attSettingStudentDao.updateNonEmptyAttSettingStudent(value,assist);
    }

    public AttSettingStudentDao getAttSettingStudentDao() {
        return this.attSettingStudentDao;
    }

    public void setAttSettingStudentDao(AttSettingStudentDao attSettingStudentDao) {
        this.attSettingStudentDao = attSettingStudentDao;
    }

}