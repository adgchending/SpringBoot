package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttRCardStudentDao;
import com.cd.basic.pojo.domain.AttRCardStudent;
import com.cd.common.Assist;
import com.cd.basic.service.AttRCardStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttRCardStudentServiceImpl implements AttRCardStudentService{
    @Autowired
    private AttRCardStudentDao attRCardStudentDao;
    @Override
    public long getAttRCardStudentRowCount(Assist assist){
        return attRCardStudentDao.getAttRCardStudentRowCount(assist);
    }
    @Override
    public List<AttRCardStudent> selectAttRCardStudent(Assist assist){
        return attRCardStudentDao.selectAttRCardStudent(assist);
    }
    @Override
    public AttRCardStudent selectAttRCardStudentByObj(AttRCardStudent obj){
        return attRCardStudentDao.selectAttRCardStudentByObj(obj);
    }
    @Override
    public AttRCardStudent selectAttRCardStudentById(Long id){
        return attRCardStudentDao.selectAttRCardStudentById(id);
    }
    @Override
    public int insertAttRCardStudent(AttRCardStudent value){
        return attRCardStudentDao.insertAttRCardStudent(value);
    }
    @Override
    public int insertNonEmptyAttRCardStudent(AttRCardStudent value){
        return attRCardStudentDao.insertNonEmptyAttRCardStudent(value);
    }
    @Override
    public int insertAttRCardStudentByBatch(List<AttRCardStudent> value){
        return attRCardStudentDao.insertAttRCardStudentByBatch(value);
    }
    @Override
    public int deleteAttRCardStudentById(Long id){
        return attRCardStudentDao.deleteAttRCardStudentById(id);
    }
    @Override
    public int deleteAttRCardStudent(Assist assist){
        return attRCardStudentDao.deleteAttRCardStudent(assist);
    }
    @Override
    public int updateAttRCardStudentById(AttRCardStudent enti){
        return attRCardStudentDao.updateAttRCardStudentById(enti);
    }
    @Override
    public int updateAttRCardStudent(AttRCardStudent value, Assist assist){
        return attRCardStudentDao.updateAttRCardStudent(value,assist);
    }
    @Override
    public int updateNonEmptyAttRCardStudentById(AttRCardStudent enti){
        return attRCardStudentDao.updateNonEmptyAttRCardStudentById(enti);
    }
    @Override
    public int updateNonEmptyAttRCardStudent(AttRCardStudent value, Assist assist){
        return attRCardStudentDao.updateNonEmptyAttRCardStudent(value,assist);
    }

    public AttRCardStudentDao getAttRCardStudentDao() {
        return this.attRCardStudentDao;
    }

    public void setAttRCardStudentDao(AttRCardStudentDao attRCardStudentDao) {
        this.attRCardStudentDao = attRCardStudentDao;
    }

}