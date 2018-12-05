# BASIC-ARTIFICIAL-NEURAL-NETWORK_FROM-LIVE-JAVA-SESSION

  Author: Jordan Micah Bennett
  
  Scenario: This is a repository that concerns a live youtube session, where I write a working, basic artificial neural network from scratch in Java in roughly 1 hour. 

  Youtube-video: [Live youtube recording, of basic neural network from scratch](https://www.youtube.com/watch?v=OhRkCb8XGj0)
  
  Why?: 
  ====
  This is practice writing of basic neural network from memory. I do this at the end of each year, or sometimes every 6 months, for practice of fundamentals. ([See other neural networks that  I've written.](https://github.com/JordanMicahBennett/NEURAL_NETWORK_PRACTICE))
  
  
  Overview
  ====
  Date: December 1, 2018
  
  The problem space is [X-OR inputs](https://en.wikipedia.org/wiki/XOR_gate). So the model does xor input prediction.
  
  Given two numbers in [X-OR space](https://en.wikipedia.org/wiki/XOR_gate), the model will try to guess the output.
  
  For:
  
  a) Input=(0,0) output should be 0
  
  b) Input=(1,0) output should be 1
  
  c) Input=(0,1) output should be 1
  
  d) Input=(1,1) output should be 0
  
 
Description of video exercise
====

1. In the video, from my memory and understanding, without using the internet, machine learning libraries nor any other resource except for Java, I write a highly accurate/working basic artificial neural network from scratch in Java that does xor prediction.

2. I practice this way every once in a while, to keep the basic neural network fresh-ish in mind mind.

3. Understanding/implementing the basic neural network from scratch, though optional, helps in applying more complicated machine learning libraries, such as tensorflow or mxnet etc.

Fun-tip: Artificial Neural Networks power most smart applications today.

4. The source code as exactly seen in [the video](https://www.youtube.com/watch?v=OhRkCb8XGj0
), is included in my github repository here, in the [source-code](https://github.com/JordanMicahBennett/BASIC-ARTIFICIAL-NEURAL-NETWORK_FROM-LIVE-JAVA-SESSION/tree/master/source%20code) directory.







Crucial note:
====
[i] At time 1:45:39, I mentioned that I changed nothing, and after time stamp 1:45:39 in the video, the model suddenly started to return excellent guesses at what the output should be, as seen in video at time 1:46:26 and beyond.

[ii] In the video, shortly before I saw good results after the time above, and after fixing some minor problems, the model was still momentarily returning guesses that were not excellent.

[iii] This is because the model needs random weights, and was initialized with random weights, so there are a few/rare times when the model would return non-excellent results. 

[iv] This can easily be fixed by initializing the model with a set of stored random weights (as I did in an earlier model, as seen in item [vi] below), or in familiar machine learning terms, "random seeds". What I could have done in the video, is additionally to save any set of weights that learned excellent representation of the input, then load those random, but saved weights all the time, or start off the program with something looking like random seeds, so as to attain excellent guesses 100% of the time, instead of roughly 95% of the time.

[v] Both random seeds or saved weights are common ways of loading good configurations of models, as seen below:

[vi] Save/Load Weights example [0] ~ A prior matrix based model of mine, where I store and load good initial weights: https://github.com/JordanMicahBennett/NEURAL-NETWORK-SIMPLE-MATRIX-VERSION/

[vii] Save/Load Weights example [1] ~ Tensorflow save and restore functionality, a somewhat similar scenario, where a learnt model can be saved: https://www.tensorflow.org/guide/saved_model

[viii] Random seed example: 
https://machinelearningmastery.com/reproducible-results-neural-networks-keras/




