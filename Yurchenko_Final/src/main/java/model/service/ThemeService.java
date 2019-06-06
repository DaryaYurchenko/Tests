package model.service;

import model.entity.Theme;
import java.util.List;
import java.util.Optional;

public interface ThemeService {

    void addTheme(Theme theme);

    void updateTheme(String column, Object value, Integer themeId);

    List<Theme> findAll();

    List<Theme> findThemesForPagination(int startRecord, int recordsPerPage);

    Optional<Theme> findThemeById(Integer themeId);

    List<Theme> findThemeByParameter(String column, Object value);

    void deleteAllThemes();

    void deleteThemeById(Integer themeId);
}
