package model.dao;

import model.entity.Question;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuestionDao extends GenericDao<Question> {

    Map<String, Integer> getCurrentAnswersOfQuestionFromDb(Long id);

    void changeAmountOfAnswersInDb(Long id, Integer plusPoints, Integer plusMaxPoints);

    List<Question> findThemeQuestions(Long themeId);

    Optional<Question> findThemeQuestionsRus(Long themeId, Long questionId);

    List<Question> findQuestionsOfThemeForPagination(int startRecord, int recordsPerPage, Long id);

}
