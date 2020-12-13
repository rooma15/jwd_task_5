package com.epam.jwd.CriteriaBuilder;

import com.epam.jwd.exception.UncompleteCriteriaException;
import com.epam.jwd.model.Color;
import com.epam.jwd.model.FigureCriteria;
import com.epam.jwd.model.FigureType;

public class CriteriaBuilder implements Builder{

    private FigureType figureType;
    private Color figureColor;
    private double bottomSquareLimit;

    @Override
    public Builder setFigureType(FigureType figureType) {
        this.figureType = figureType;
        return this;
    }

    @Override
    public Builder setFigureColor(Color figureColor) {
        this.figureColor = figureColor;
        return this;
    }

    @Override
    public Builder setBottomSquareLimit(double squareLimit) {
        this.bottomSquareLimit = squareLimit;
        return this;
    }

    public FigureCriteria getCriteria(){
        if(figureType == null || figureColor == null){
            throw new UncompleteCriteriaException("не все необходимые поля критерия были заполнены");
        }
        return new FigureCriteria(figureType, figureColor, bottomSquareLimit);
    }

}
