# NOTE

In case any of the links below are not working, most of the documents (Vision statement, Architecture, etc.) are available under /docs directory.

# Iteration 0

Vision statement (Iteration 0)
- Please refer to [vision_statement.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/vision_statement.md)

# Architecture (Iteration 1)

- Please refer to [ARCHITECTURE.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/ARCHITECTURE.md)
- For the diagram, please refer to [architecture_diagram.png](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/architecture_diagram.png)

# Architecture (Iteration 2)

- Please refer to [ARCHITECTURE_ITERATION2.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/ARCHITECTURE_ITERATION2.md)
- For the diagram, please refer to [ARCHITECTURE_DIAGRAM_ITERATION2.png](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/ARCHITECTURE_DIAGRAM_ITERATION2.PNG)
 
# Branching Strategy

Worksheet (Iteration 1)
- Please refer to [worksheet_iteration1.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/worksheet_iteration1.md)

# Iteration 2

Architecture (Iteration 2)
- Please refer to [architecture_iteration2.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/architecture_iteration2.md)
- For the diagram, please refer to [architecture_diagram_iteration2.png](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/architecture_diagram_iteration2.PNG)

Worksheet (Iteration 2)
- Please refer to [worksheet_iteration2.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/worksheet_iteration2.md)

# Iteration 3

To be added later...

# Branching Strategy

Please refer to [branching_strategy.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/branching_strategy.md)

# Coding Standards

Please refer to [Worksheet_Iteration2.md](https://code.cs.umanitoba.ca/3350-winter-2021-a02/group-6/aurora-but-better-a02-group-6/-/blob/master/docs/Worksheet_Iteration2.md)

# How to open a static website

1. Open terminal
2. Change directory to **aurora-but-better-a02-group6/website**
3. Run the following command (once done, you can skip to the step 4 whenever you want to launch the website)
    ```
    bundle install
    ```
4. Run the following command
    ```
    bundle exec jekyll serve
    ```
    
    Below is a snapshot of what you should see on successful run of the above command.
    ```
    $ bundle exec jekyll serve
    Configuration file: E:/Github/comp3350/aurora-but-better-a02-group-6/website/_config.yml
                Source: E:/Github/comp3350/aurora-but-better-a02-group-6/website
        Destination: E:/Github/comp3350/aurora-but-better-a02-group-6/website/_site
    Incremental build: disabled. Enable with --incremental
        Generating...
        Jekyll Feed: Generating feed for posts
                        done in 0.168 seconds.
    Please add the following to your Gemfile to avoid polling for changes:
        gem 'wdm', '>= 0.1.0' if Gem.win_platform?
    Auto-regeneration: enabled for 'E:/Github/comp3350/aurora-but-better-a02-group-6/website'
        Server address: http://127.0.0.1:4000/ubuild-jekyll/
    Server running... press ctrl-c to stop.
    
    ```
5. Access the static website by using either of one the following links
    ```
    http://127.0.0.1:4000/ubuild-jekyll/
    http://localhost:4000/ubuild-jekyll/
    ```
6. Should you have any issues, let us know!