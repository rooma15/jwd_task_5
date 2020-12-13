package com.epam.jwd.CriteriaBuilder;

import com.epam.jwd.model.Color;
import com.epam.jwd.model.FigureType;

public interface Builder {
    Builder setFigureType(FigureType type);
    Builder setFigureColor(Color color);
    Builder setBottomSquareLimit(double limit);
}
