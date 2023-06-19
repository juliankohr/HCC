# DBM - Datenbasierte Modellierung
## Wine Classifier

Student: Julian Kohr<br>
Matriculation no.: 52203961<br>
Course: Data based modeling (DBM2I)<br>
Lecturer: Dipl.-Ing. Alessio Montuoro

### Intro
This classifier was trained to classify Portuguese vinho verde into red and white wines based on their chemical composition such as acids, sugars, etc. Therefore the wine quality dataset from [UC Irvine](https://archive.ics.uci.edu/dataset/186/wine+quality) was used. The set includes two .csv files related to red and white vinho verde wine samples, from the north of Portugal. Vinho verde is a unique product from the Minho (northwest) region of Portugal. Medium in alcohol, is it particularly appreciated due to its freshness (specially in the summer). More details can be found at: http://www.vinhoverde.pt/en/. The initial goal was to model wine quality based on physicochemical tests (see [Cortez et al., 2009](http://dx.doi.org/10.1016/j.dss.2009.05.016)). For my assignment I set another goal so the model should be able to predict if a physicochemical sample belongs to a red or a white wine. This could lateron help to gain certainty if a sample is recorded in the right file (red or white). Based on the prediction, incorrectly entered samples can be entered into the correct table and errors can be corrected.
