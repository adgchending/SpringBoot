package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttStudentCardDao;
import com.cd.basic.pojo.domain.AttStudentCard;
import com.cd.common.Assist;
import com.cd.basic.service.AttStudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttStudentCardServiceImpl implements AttStudentCardService{
    @Autowired
    private AttStudentCardDao attStudentCardDao;
    @Override
    public long getAttStudentCardRowCount(Assist assist){
        return attStudentCardDao.getAttStudentCardRowCount(assist);
    }
    @Override
    public List<AttStudentCard> selectAttStudentCard(Assist assist){
        return attStudentCardDao.selectAttStudentCard(assist);
    }
    @Override
    public AttStudentCard selectAttStudentCardByObj(AttStudentCard obj){
        return attStudentCardDao.selectAttStudentCardByObj(obj);
    }
    @Override
    public AttStudentCard selectAttStudentCardById(Long id){
        return attStudentCardDao.selectAttStudentCardById(id);
    }
    @Override
    public int insertAttStudentCard(AttStudentCard value){
        return attStudentCardDao.insertAttStudentCard(value);
    }
    @Override
    public int insertNonEmptyAttStudentCard(AttStudentCard value){
        return attStudentCardDao.insertNonEmptyAttStudentCard(value);
    }
    @Override
    public int insertAttStudentCardByBatch(List<AttStudentCard> value){
        return attStudentCardDao.insertAttStudentCardByBatch(value);
    }
    @Override
    public int deleteAttStudentCardById(Long id){
        return attStudentCardDao.deleteAttStudentCardById(id);
    }
    @Override
    public int deleteAttStudentCard(Assist assist){
        return attStudentCardDao.deleteAttStudentCard(assist);
    }
    @Override
    public int updateAttStudentCardById(AttStudentCard enti){
        return attStudentCardDao.updateAttStudentCardById(enti);
    }
    @Override
    public int updateAttStudentCard(AttStudentCard value, Assist assist){
        return attStudentCardDao.updateAttStudentCard(value,assist);
    }
    @Override
    public int updateNonEmptyAttStudentCardById(AttStudentCard enti){
        return attStudentCardDao.updateNonEmptyAttStudentCardById(enti);
    }
    @Override
    public int updateNonEmptyAttStudentCard(AttStudentCard value, Assist assist){
        return attStudentCardDao.updateNonEmptyAttStudentCard(value,assist);
    }

    public AttStudentCardDao getAttStudentCardDao() {
        return this.attStudentCardDao;
    }

    public void setAttStudentCardDao(AttStudentCardDao attStudentCardDao) {
        this.attStudentCardDao = attStudentCardDao;
    }

}