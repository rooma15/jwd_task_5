package com.epam.jwd.model;


import java.util.Optional;

public class FigureCriteria {
    private final FigureType figureType;
    private final Color figureColor;
    private final Double bottomSquareLimit;
    private final Integer figureId;
    private final Integer bottomIdBorder;
    private final Integer topIdBorder;

    private FigureCriteria(FigureType figureType,
                           Color figureColor,
                           Double bottomSquareLimit,
                           Integer figureId,
                           Integer bottomRangeIdBorder,
                           Integer topRangeIdBorder) {
        this.figureType = figureType;
        this.figureColor = figureColor;
        this.bottomSquareLimit = bottomSquareLimit;
        this.figureId = figureId;
        this.bottomIdBorder = bottomRangeIdBorder;
        this.topIdBorder = topRangeIdBorder;
    }

    public Optional<Color> getFigureColor() {
        return Optional.ofNullable(figureColor);
    }

    public Optional<Double> getBottomSquareLimit() {
        return Optional.ofNullable(bottomSquareLimit);
    }

    public Optional<FigureType> getFigureType() {
        return Optional.ofNullable(figureType);
    }

    public Optional<Integer> getFigureId(){
        return Optional.ofNullable(figureId);
    }

    public Optional<Integer[]> getRangId(){
        if(bottomIdBorder == null && topIdBorder == null){
            return Optional.empty();
        }else{
            return Optional.of(new Integer[]{bottomIdBorder, topIdBorder});
        }
    }





    public static class CriteriaBuilder{

        private FigureType figureType;
        private Color figureColor;
        private Double bottomSquareLimit;
        private Integer figureId;
        private Integer bottomIdBorder;
        private Integer topIdBorder;

        public CriteriaBuilder setFigureType(FigureType figureType) {
            this.figureType = figureType;
            return this;
        }


        public CriteriaBuilder setFigureColor(Color figureColor) {
            this.figureColor = figureColor;
            return this;
        }


        public CriteriaBuilder setBottomSquareLimit(double squareLimit) {
            this.bottomSquareLimit = squareLimit;
            return this;
        }

        public CriteriaBuilder setFigureId(int figureId){
            this.figureId = figureId;
            return this;
        }

        public CriteriaBuilder setIdRange(int bottomIdBorder, int topIdBorder){
            this.bottomIdBorder = bottomIdBorder;
            this.topIdBorder = topIdBorder;
            return this;
        }

        public FigureCriteria getCriteria(){

            return new FigureCriteria(figureType, figureColor, bottomSquareLimit, figureId, bottomIdBorder, topIdBorder);
        }

    }
}
