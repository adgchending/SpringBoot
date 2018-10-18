package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttRecordStudentDao;
import com.cd.basic.pojo.domain.AttRecordStudent;
import com.cd.common.Assist;
import com.cd.basic.service.AttRecordStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttRecordStudentServiceImpl implements AttRecordStudentService{
    @Autowired
    private AttRecordStudentDao attRecordStudentDao;
    @Override
    public long getAttRecordStudentRowCount(Assist assist){
        return attRecordStudentDao.getAttRecordStudentRowCount(assist);
    }
    @Override
    public List<AttRecordStudent> selectAttRecordStudent(Assist assist){
        return attRecordStudentDao.selectAttRecordStudent(assist);
    }
    @Override
    public AttRecordStudent selectAttRecordStudentByObj(AttRecordStudent obj){
        return attRecordStudentDao.selectAttRecordStudentByObj(obj);
    }
    @Override
    public AttRecordStudent selectAttRecordStudentById(Long id){
        return attRecordStudentDao.selectAttRecordStudentById(id);
    }
    @Override
    public int insertAttRecordStudent(AttRecordStudent value){
        return attRecordStudentDao.insertAttRecordStudent(value);
    }
    @Override
    public int insertNonEmptyAttRecordStudent(AttRecordStudent value){
        return attRecordStudentDao.insertNonEmptyAttRecordStudent(value);
    }
    @Override
    public int insertAttRecordStudentByBatch(List<AttRecordStudent> value){
        return attRecordStudentDao.insertAttRecordStudentByBatch(value);
    }
    @Override
    public int deleteAttRecordStudentById(Long id){
        return attRecordStudentDao.deleteAttRecordStudentById(id);
    }
    @Override
    public int deleteAttRecordStudent(Assist assist){
        return attRecordStudentDao.deleteAttRecordStudent(assist);
    }
    @Override
    public int updateAttRecordStudentById(AttRecordStudent enti){
        return attRecordStudentDao.updateAttRecordStudentById(enti);
    }
    @Override
    public int updateAttRecordStudent(AttRecordStudent value, Assist assist){
        return attRecordStudentDao.updateAttRecordStudent(value,assist);
    }
    @Override
    public int updateNonEmptyAttRecordStudentById(AttRecordStudent enti){
        return attRecordStudentDao.updateNonEmptyAttRecordStudentById(enti);
    }
    @Override
    public int updateNonEmptyAttRecordStudent(AttRecordStudent value, Assist assist){
        return attRecordStudentDao.updateNonEmptyAttRecordStudent(value,assist);
    }

    public AttRecordStudentDao getAttRecordStudentDao() {
        return this.attRecordStudentDao;
    }

    public void setAttRecordStudentDao(AttRecordStudentDao attRecordStudentDao) {
        this.attRecordStudentDao = attRecordStudentDao;
    }

}