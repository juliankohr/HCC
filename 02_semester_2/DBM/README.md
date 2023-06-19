# DBM - Data based modeling
## Wine Classifier

Student: Julian Kohr<br>
Matriculation no.: 52203961<br>
Course: Data based modeling (DBM2I)<br>
Lecturer: Dipl.-Ing. Alessio Montuoro

### Intro
This classifier was trained to classify Portuguese vinho verde into red and white wines based on their chemical composition such as acids, sugars, etc. Therefore the wine quality dataset from [UC Irvine](https://archive.ics.uci.edu/dataset/186/wine+quality) was used. The set includes two .csv files related to red and white vinho verde wine samples, from the north of Portugal. Vinho verde is a unique product from the Minho (northwest) region of Portugal. Medium in alcohol, is it particularly appreciated due to its freshness (specially in the summer). More details can be found at: http://www.vinhoverde.pt/en/. The initial goal was to model wine quality based on physicochemical tests (see [Cortez et al., 2009](http://dx.doi.org/10.1016/j.dss.2009.05.016)). For my assignment I set another goal so the model should be able to predict if a physicochemical sample belongs to a red or a white wine. This could lateron help to gain certainty if a sample is recorded in the right file (red or white). Based on the prediction, incorrectly entered samples can be entered into the correct table and errors can be corrected.

### Process
#### Data preparation
After loading the data, a list of the corresponding wine types is created and attached to the data frame resulting from the merging of the two data sets (winequality-red.csv and winequality-white.csv).
For my project, the column with the quality specification of the respective wines is not needed, since this is subjective and does not provide a measurable parameter. This value is stripped and the data frame is first divided into features and target. The target is the respective wine type. For the training and the subsequent tests, the data set was divided into three subsets for training, validation and testing.

#### Training
A total of four models were trained to find the model that achieved the best performance. Random Forest Classifier, Logistic Regression, Gradient Boosting Classifier and Support Vector Machines (SVM) were used and tested against the validation subset. The Random Forest Classifier showed the best results with a validation accuracy of 0.9938.

#### Testing
Since the random forest classifier had the best validation accuracy, it was tested against the testing subset at the end. This resulted in an accuracy of 0.9969.

#### Findings
Based on the outcomes of the wine classifier training, the following findings can be observed:

1. Dataset: The wine dataset consists of chemical composition features of Portuguese vinho verde wines, including attributes such as acids, sugars, and more. The dataset was divided into red and white wines.

2. Model Training: Four different classification models were trained on the dataset: Random Forest Classifier, Logistic Regression, Gradient Boosting Classifier, and Support Vector Machines (SVM).

3. Training Progress: The training progress for each model was monitored over multiple iterations to observe the change in accuracy. For each model, the training and validation accuracies were recorded and plotted.

   - Random Forest Classifier: The Random Forest Classifier achieved high accuracy on both the training and validation sets, with a consistently high performance throughout the iterations.
   
   - Logistic Regression: The Logistic Regression model also showed good accuracy on both the training and validation sets, with a relatively stable performance over the iterations.
   
   - Gradient Boosting Classifier: The Gradient Boosting Classifier exhibited an increasing trend in accuracy on the training set and achieved high accuracy on the validation set, indicating a good learning capability.
   
   - Support Vector Machines (SVM): The SVM model showed relatively high accuracy on both the training and validation sets, with a stable performance throughout the iterations.

4. Model Selection: Among the trained models, the Random Forest Classifier consistently demonstrated the highest accuracy on both the training and validation sets. Therefore, it was selected as the best performing model for further evaluation.

5. Testing Accuracy: The selected Random Forest Classifier was evaluated on the subset reserved for testing, and it achieved a high accuracy score. This indicates that the model generalizes well to unseen data.

Based on these findings, it can be concluded that the Random Forest Classifier is the most suitable model for classifying the Portuguese vinho verde wines into red and white categories based on their chemical composition.

### Citation
This dataset is public available for research. The details are described in [Cortez et al., 2009](http://www3.dsi.uminho.pt/pcortez/wine/). 

P. Cortez, A. Cerdeira, F. Almeida, T. Matos and J. Reis.<br>
Modeling wine preferences by data mining from physicochemical properties.<br>
In Decision Support Systems, Elsevier, 47(4):547-553. ISSN: 0167-9236.<br>

Available at:<br>
Elsevier http://dx.doi.org/10.1016/j.dss.2009.05.016<br>
Pre-press (pdf) http://www3.dsi.uminho.pt/pcortez/winequality09.pdf<br>
bib http://www3.dsi.uminho.pt/pcortez/dss09.bib<br>
